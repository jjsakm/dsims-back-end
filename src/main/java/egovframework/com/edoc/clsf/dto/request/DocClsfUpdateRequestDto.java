package egovframework.com.edoc.clsf.dto.request;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "문서분류 수정")
@Getter
@Setter
public class DocClsfUpdateRequestDto implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6800848624760409230L;

	@Schema(description = "문서분류번호", example = "")
	private String docClsfNo; // 문서분류번호
	
	@Schema(description = "문서분류명", example = "")
	private String docClsfNm; // 문서분류명
	
	@Schema(description = "상위문서분류번호", example = "")
	private String upDocClsfNo; // 상위문서분류번호
	
	@Schema(description = "개인정보 포함여부(Y:포함, N:미포함)", example = "")
	private String prvcInclYn; // 개인정보 포함여부(Y:포함, N:미포함)
	
	@Schema(description = "사용유무(Y:사용, N:미사용)", example = "")
	private String useEn; // 사용유무(Y:사용, N:미사용)

	@Schema(description = "수정자", example = "", hidden = true)
	private String mdfrId;

	@Schema(description = "개인정보파일보유현황", example = "")
	private PrvcFileHldPrstUpsertRequestDto prvcFileHldPrst;

	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}