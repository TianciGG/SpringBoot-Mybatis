//package chauncy.datasource;
//
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
///**   
// * @classDesc: 功能描述(数据源1的配置)  
// * @author: ChauncyWang
// * @createTime: 2019年5月22日 下午3:15:05   
// * @version: 1.0  
// */ 
//@Configuration // 注册到spring容器中
//@MapperScan(basePackages="chauncy.test01",sqlSessionFactoryRef="test1SqlSessionFactory")
//public class Datasource1 {
//	
//	/**   
//	 * @methodDesc: 功能描述(配置test1数据库)  
//	 * @author: ChauncyWang
//	 * @param: @return   
//	 * @createTime: 2019年5月22日 下午3:18:11   
//	 * @returnType: DataSource  
//	 */  
//	@Bean(name = "test1DataSource")
//	@Primary
//	@ConfigurationProperties(prefix = "spring.datasource.test1")
//	public DataSource testDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	
//	/**   
//	 * @methodDesc: 功能描述(test1 sql会话工厂)  
//	 * @author: ChauncyWang
//	 * @param: @param dataSource
//	 * @param: @return
//	 * @param: @throws Exception   
//	 * @createTime: 2019年5月22日 下午3:18:45   
//	 * @returnType: SqlSessionFactory  
//	 */  
//	@Bean(name = "test1SqlSessionFactory")
//	@Primary
//	public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
//			throws Exception {
//		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//		bean.setDataSource(dataSource);
////		bean.setMapperLocations(
////				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
//		return bean.getObject();
//	}
//
//
//	/**   
//	 * @methodDesc: 功能描述(test1 事物管理)  
//	 * @author: ChauncyWang
//	 * @param: @param dataSource
//	 * @param: @return   
//	 * @createTime: 2019年5月22日 下午3:19:09   
//	 * @returnType: DataSourceTransactionManager  
//	 */  
//	@Bean(name = "test1TransactionManager")
//	@Primary
//	public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}
//
//	@Bean(name = "test1SqlSessionTemplate")
//	public SqlSessionTemplate testSqlSessionTemplate(
//			@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//
//}
