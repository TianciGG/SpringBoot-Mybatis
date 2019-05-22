package chauncy.datasource;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**   
 * @classDesc: 功能描述(数据源2的配置)  
 * @author: ChauncyWang
 * @createTime: 2019年5月22日 下午3:15:05   
 * @version: 1.0  
 */ 
@Configuration // 注册到spring容器中
@MapperScan(basePackages="chauncy.test02",sqlSessionFactoryRef="test2SqlSessionFactory")
public class Datasource2 {
	
	/**   
	 * @methodDesc: 功能描述(配置test2数据库)  
	 * @author: ChauncyWang
	 * @param: @return   
	 * @createTime: 2019年5月22日 下午3:18:11   
	 * @returnType: DataSource  
	 */  
	@Bean(name = "test2DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.test2")
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

	
	/**   
	 * @methodDesc: 功能描述(test2 sql会话工厂)  
	 * @author: ChauncyWang
	 * @param: @param dataSource
	 * @param: @return
	 * @param: @throws Exception   
	 * @createTime: 2019年5月22日 下午3:18:45   
	 * @returnType: SqlSessionFactory  
	 */  
	@Bean(name = "test2SqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
//		bean.setMapperLocations(
//				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test2/*.xml"));
		return bean.getObject();
	}


	/**   
	 * @methodDesc: 功能描述(test2 事物管理)  
	 * @author: ChauncyWang
	 * @param: @param dataSource
	 * @param: @return   
	 * @createTime: 2019年5月22日 下午3:19:09   
	 * @returnType: DataSourceTransactionManager  
	 */  
	@Bean(name = "test2TransactionManager")
	public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "test2SqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
