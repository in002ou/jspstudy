package common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActionForward {
	private String path;		// 이동할 Jsp 경로
	private boolean isRedirect;	// 이동 방식(true이면 ridirect, false이면 forward)
}
