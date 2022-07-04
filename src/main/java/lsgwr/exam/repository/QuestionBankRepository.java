/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019-05-14 08:25
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package lsgwr.exam.repository;

import lsgwr.exam.entity.Question;
import lsgwr.exam.entity.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionBankRepository extends JpaRepository<QuestionBank, String> {


    @Query("select q from QuestionBank q order by q.updateTime desc")
    List<QuestionBank> findAll();
}
