import com.oa.utils.MybatisUtils;
import org.junit.Test;

public class MybatisUtilsTest {
    @Test
    public void testCase1() {
        String result = (String) MybatisUtils.executeQuery(sqlSession -> sqlSession.<String>selectOne("test.sample"));
        System.out.println(result);
    }


}
