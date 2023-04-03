package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 게터세터(롬복)
@Setter
@Getter
// 생성자(롬복)
@AllArgsConstructor
@NoArgsConstructor
// sql과 동일하게 작성
public class BoardDTO {
	private int board_no;
	private String title;
	private String content;
	private Date modified_date;
	private Date created_date;
}
