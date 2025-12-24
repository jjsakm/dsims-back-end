package egovframework.com.edoc.clsf.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DocClsfHistActCn {
	INSERT("문서분류 등록"),
	UPDATE("문서분류 수정"),
	DELETE("문서분류 삭제");
	
	@Getter
	private final String name;
}
