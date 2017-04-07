/**
 * 		[	 커넥션 풀	]
 * 		: DB와 연결된 Connection을 미리 만들어서 풀(pool) 속에
 * 		  저장해 두고 있다가 필요할 때에 커넥션 풀에서 가져다 쓰고 다시 풀에 반환하는 기법
 * 
 * 		장점)
 * 			- 페이지 요청시마다 매번 Connection 객체를 생성하는 비효율성을 없애고
 * 			   미리 생성해 놓은 Connection 객체를 풀에서 꺼내와서 사용함으로써 효율을 높인다.
 * 			- 미리 만들어 놓은 객체를 재사용하기 때문에 무제한적으로 커넥션 객체가 생성되는 것을 방지할 수 있다.
 * 		방법)
 * 			servers폴더에 보면 context.xml이 있다.

 * 				=> server.xml or context.xml 둘 중 한군대다 DBCP 설정을 작성해 주면 된다.								
 */
package book_self;

public class pool {

}
