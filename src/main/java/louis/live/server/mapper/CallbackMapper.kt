package louis.live.server.mapper

import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface CallbackMapper {

    @Update(
            "<script>",
            "update live_info set status=#{newStatus} where streamcode=#{streamCode} and status=#{oldStatus}"
            ,"</script>"
    )
    fun changeLiveStatus(params: Map<*, *>)
}