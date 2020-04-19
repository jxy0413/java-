package cn.test.druid.mapper;
import cn.test.druid.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther jxy
 * @Date 2020-04-19
 */
public interface TestJpaMapper extends JpaRepository<User,Integer> {

}
