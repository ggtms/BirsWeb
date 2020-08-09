package com.cqupt.bcirs.dao;

import com.cqupt.bcirs.domain.Card;
import com.cqupt.bcirs.domain.Picture;
import com.cqupt.bcirs.service.Status;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ggtms
 * @ 2020-04-14 15:17
 */
@Repository             //此注解代表这是一个持久层，用法类似@controller、@service
public interface CardDao {
    //显示全部信息
    @Select("select * from card")
    Card findAl();

    //用List显示全部信息
    @Select("select * from card")
    List<Card> findAllList();

    //存储信息
    @Insert("insert into card (issuer,account,date,status) value(#{issuer},#{account},#{date},#{status})")
    void saveBankCard(Card card);

    //删除缓存
    /*@Delete("delete from card where number = #{number}")
    void deleteBankCard(int number);*/
    @Delete("delete from card")
    void deleteBankCard();
}

/*
package com.cqupt.bcirs.dao;

        import com.cqupt.bcirs.domain.Picture;
        import org.apache.ibatis.annotations.Select;
        import org.springframework.stereotype.Repository;

        import java.util.List;

*/
/**
 * @author ggtms
 * @ 2020-04-14 10:25
 *//*

@Repository  //此注解代表这是一个持久层，用法类似@controller、@service
public interface PictureDao {

    //显示全部信息
    List<Picture> findAll();

    //存储信息
    void saveBankCard(Picture picture);

    //返回传入图片的路径
    @Select("select path from picture")
    String getImagePath();

}
*/

