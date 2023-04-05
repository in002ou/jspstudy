package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.BbsDTO;
import oracle.net.aso.s;

public class BbsDAO {
	
	// 필드
	private SqlSessionFactory factory;
	
	// Singleton Pattern
	private static BbsDAO dao = new BbsDAO();
	private BbsDAO() {
		
		try {
			// factory 만드는 코드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory= new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static BbsDAO getInstance() {
		return dao;
	}
	
	/* 메소드명과 쿼리문의 id를 맞추는 걸 권장 */
	
	// mapper의 namespace
	private final String NS = "mybatis.mapper.bbs.";
	
	// 1. 목록
	public List<BbsDTO> selectAllBbsList() {
		SqlSession ss = factory.openSession();
		// return에 ss.selectList(NS + "selectAllBbsList");를 바로 반환하면 array리스트를 만들어서 자동으로 저장이 되지만 ss을 close를 해줘야 하기때문에 문제가 발생할 수 있다.
		List<BbsDTO> bbsList = ss.selectList(NS + "selectAllBbsList");	// mapper's namespace + query's id
		ss.close();
		return bbsList;
	}
	
	// 2. 상세
	public BbsDTO selectBbsByNo(int bbsNo) {
		SqlSession ss = factory.openSession();
		// selectBbsByNo에 bbsNo 전달
		BbsDTO bbs = ss.selectOne(NS + "selectBbsByNo", bbsNo);
		ss.close();
		return bbs;
	}
	
	// 3. 삽입
	public int insertBbs(BbsDTO bbs) {
		SqlSession ss = factory.openSession(false);	// autoCommit을 하지 않고 수동으로 하겠다.
		int insertResult = ss.insert(NS + "insertBbs", bbs);
		if(insertResult == 1) {		// 삽입 성공 시
			ss.commit();			// commit 하시오
		}
		ss.close();
		return insertResult;
	}
	
	// 4. 수정
	public int updateBbs(BbsDTO bbs) {
		SqlSession ss = factory.openSession(false);
		int updateResult = ss.update(NS + "updateBbs", bbs);
		if(updateResult == 1) {
			ss.commit();
		}
		ss.close();
		return updateResult;
	}
	
	// 5. 삭제
	public int deleteBbs(int bbsNo) {
		SqlSession ss = factory.openSession(false);
		int deleteResult = ss.delete(NS + "deleteBbs", bbsNo);
		if(deleteResult == 1) {
			ss.commit();
		}
		ss.close();
		return deleteResult;
	}
	
}
