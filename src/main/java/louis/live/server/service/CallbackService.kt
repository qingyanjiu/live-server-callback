package louis.live.server.service

import louis.live.server.mapper.CallbackMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CallbackService {

    @Autowired
    private val callbackMapper: CallbackMapper? = null

    //直播间状态(开启中但未直播-0)
    private val LIVE_STATUS_STARTED: String = "0"
    //直播间状态(正在直播-9)
    private val LIVE_STATUS_LIVE: String = "9"

    //进入直播状态
    fun startLive(params: HashMap<String, String>) {
        try {
            //要匹配的直播间状态(开启中但未直播-0)
            params["newStatus"] = LIVE_STATUS_LIVE
            params["oldStatus"] = LIVE_STATUS_STARTED
            callbackMapper?.changeLiveStatus(params)
        } catch (e: Exception) {
            println("start live failed")
        }
    }


    fun endLive(params: HashMap<String, String>) {
        try {
            //要匹配的直播间状态(正在直播-9)
            params["oldStatus"] = LIVE_STATUS_LIVE
            params["newStatus"] = LIVE_STATUS_STARTED
            callbackMapper?.changeLiveStatus(params)
        } catch (e: Exception) {
            println("start live failed")
        }
    }
}