package br.com.lucasfcarneiro.projetoempresas.utils.extensions

import br.com.lucasfcarneiro.projetoempresas.data.Response
import br.com.lucasfcarneiro.projetoempresas.data.model.ErrorModel
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException

open class DataSourceException(message: String? = null, code: Int? = null) : Exception(message)
class RemoteDataNotFoundException(message: String?, code: Int? = null) : DataSourceException(message, code)
class NoContentException(message: String?, code: Int? = null) : DataSourceException(message, code)
class NoInternetException(message: String? = "No Internet Connection", code: Int? = 503) :
    DataSourceException(message, code)

class ServerException(message: String?) : Exception(message)

suspend fun <T : Any> safeApiCall(
    isOnline: () -> Boolean,
    call: suspend () -> T?
)
        : Response<T> {
    return when {
        isOnline() -> {
            try {
                val dataFromRemote = call()
                if (dataFromRemote != null){
                    Response.Success(dataFromRemote)
                }else{
                    Response.Error(NoContentException("No Content", 204))
                }

            } catch (httpException: HttpException) {
                val message = Gson().fromJson(httpException.response()?.errorBody()?.string(), ErrorModel::class.java)
                if (message?.messages != null){
                    Response.Error(RemoteDataNotFoundException(message.messages[0], httpException.code()))
                }else{
                    Response.Error(RemoteDataNotFoundException("", httpException.code()))
                }

            } catch (ioException: IOException) {
                Response.Error(ServerException(ioException.message))
            }catch (ex : Exception){
                Response.Error(Throwable("error"))
            }
        }
        else -> Response.Error(NoInternetException())
    }
}