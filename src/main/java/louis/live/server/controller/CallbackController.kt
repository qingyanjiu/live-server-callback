package louis.live.server.controller

import louis.live.server.service.CallbackService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/")
class CallbackController {

    @Autowired
    private val callbackService: CallbackService? = null

    @RequestMapping("startLive")
    fun startLive(streamCode: String, response: HttpServletResponse){
        var params = HashMap<String, String>()
        params["streamCode"] = streamCode
        try {
            callbackService?.startLive(params)
            response.status = 200
            response.setHeader("Content-Type", "text/html;charset=utf-8")
        } catch (e: Exception) {
            println("start live failed")
            response.writer.write("error")
        }
    }

    @RequestMapping("endLive")
    fun endLive(streamCode: String, response: HttpServletResponse){
        var params = HashMap<String, String>()
        params["streamCode"] = streamCode
        try {
            callbackService?.endLive(params)
            response.status = 200
            response.setHeader("Content-Type", "text/html;charset=utf-8")
        } catch (e: Exception) {
            println("end live failed")
            response.writer.write("error")
        }
    }

}