package cn.test.druid.model;

import lombok.Data;
import lombok.ToString;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Auther jxy
 * @Date 2020-04-30
 */
@Data
@ToString
public class Ecodata {
    private Long datanumId;
    private Integer stationId;
    private Integer deviceId;
    private Integer datatypeId;
    private Date dataTime;
    private Double dataValue;
    private Integer exceptionFlag;
}
