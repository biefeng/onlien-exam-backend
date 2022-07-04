/***********************************************************
 * @Description : 考试的前端展示类。examCreatorId可从token中获取
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019-06-17 08:14
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package lsgwr.exam.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExamRandomCreateVo {

    @JsonProperty("questionBankId")
    private String questionBankId;

    private boolean random;

    /**
     * 单选题的分数
     */
    @JsonProperty("radioScore")
    private Integer examScoreRadio = 5;

    /**
     * 多选题的分数
     */
    @JsonProperty("checkScore")
    private Integer examScoreCheck = 5;

    /**
     * 判断题每题的分数
     */
    @JsonProperty("judgeScore")
    private Integer examScoreJudge = 5;

    /**
     * 单选数量
     */
    private Integer radioCount = 10;

    /**
     * 多选数量
     */
    private Integer checkCount = 10;

    /**
     * 判断题数量
     */
    private Integer judgeCount = 10;

    public Integer getTotalScore() {
        return radioCount * examScoreRadio + checkCount * examScoreCheck + judgeCount * examScoreJudge;
    }
}
