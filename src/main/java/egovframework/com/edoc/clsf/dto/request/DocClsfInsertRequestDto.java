package egovframework.com.edoc.clsf.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "문서분류 등록")
@Getter
@Setter
public class DocClsfInsertRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6478162443783502376L;

	@Schema(description = "문서분류 번호", example = "", hidden = true)
	private String docClsfNo;

	@Schema(description = "문서분류 구분코드", example = "")
	@NotNull
	private String docClsfSeCd;

	@Schema(description = "문서분류명", example = "")
	private String docClsfNm = "";

	@Schema(description = "상위문서분류 번호", example = "")
	private String upDocClsfNo;

	@Schema(description = "개인정보포함여부", example = "")
	private String prvcInclYn;

	@Schema(description = "사용유무", example = "")
	private String useEn;

	@Schema(description = "등록자", example = "", hidden = true)
	private String rgtrId;

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