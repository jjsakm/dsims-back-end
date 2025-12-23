package egovframework.com.edoc.clsf.domain.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "문서분류")
@Getter
@Setter
public class PrvcFileHldPrstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6239302856645724370L;

	@Schema(description = "문서분류번호", example = "")
	private String docClsfNo; // 문서분류번호
	
	@Schema(description = "개인정보파일보유현황번호", example = "")
	private String prvcFileHldPrstNo; // 개인정보파일보유현황번호
	
	@Schema(description = "부서명", example = "")
	private String deptNm; // 부서명
	
	@Schema(description = "파일명", example = "")
	private String fileNm; // 파일명
	
	@Schema(description = "보유목적", example = "")
	private String hldPrps; // 보유목적
	
	@Schema(description = "수집근거(법령)", example = "")
	private String clctSttBssExpln; // 수집근거(법령)
	
	@Schema(description = "사용부서명", example = "")
	private String useDeptNm; // 사용부서명
	
	@Schema(description = "개인정보 처리방법", example = "")
	private String prvcPrcsMthdExpln; // 개인정보 처리방법
	
	@Schema(description = "보유기간 년(1/3/5/10/30/준영구(90)/영구(99)/직접입력(0))", example = "")
	private Integer  hldPrdDfyrs; // 보유기간 년(1/3/5/10/30/준영구/영구/직접입력)
	
	@Schema(description = "보유기간 월", example = "")
	private Integer hldPrdMmCnt; // 보유기간 월
	
	@Schema(description = "정보주체 개인정보항목", example = "")
	private String infoMnbdPrvcMttr; // 정보주체 개인정보항목
	
	@Schema(description = "법정대리인 개인정보항목", example = "")
	private String sttyAgtPrvcMttr; // 법정대리인 개인정보항목
	
	@Schema(description = "주민등록번호 수집여부(Y:수집, N:미수집)", example = "")
	private String rrnoClctYn; // 주민등록번호 수집여부(Y:수집, N:미수집)
	
	@Schema(description = "주민등록번호 수집 법령근거", example = "")
	private String rrnoClctSttBssExpln; // 주민등록번호 수집 법령근거
	
	@Schema(description = "정보주체 동의여부(Y:동의, N:미동의)", example = "")
	private String infoMnbdAgreYn; // 정보주체 동의여부(Y:동의, N:미동의)
	
	@Schema(description = "정보주체 동의 없이 수집 법령근거", example = "")
	private String infoMnbdDsagClctSttBssExpln; // 정보주체 동의 없이 수집 법령근거
	
	@Schema(description = "민감정보 보유여부(Y:보유, N:미보유)", example = "")
	private String sensInfoHldYn; // 민감정보 보유여부(Y:보유, N:미보유)
	
	@Schema(description = "민감정보 별도 동의여부(Y:동의, N:미동의)", example = "")
	private String sensInfoIndivAgreYn; // 민감정보 별도 동의여부(Y:동의, N:미동의)
	
	@Schema(description = "민감정보 보유 법령근거", example = "")
	private String sensInfoHldSttBssExpln; // 민감정보 보유 법령근거
	
	@Schema(description = "고유식별정보 보유여부(Y:보유, N:미보유)", example = "")
	private String uiiHldYn; // 고유식별정보 보유여부(Y:보유, N:미보유)
	
	@Schema(description = "고유식별정보 별도 동의여부(Y:동의, N:미동의)", example = "")
	private String uiiIndivAgreYn; // 고유식별정보 별도 동의여부(Y:동의, N:미동의)
	
	@Schema(description = "고유식별정보 보유 법령근거", example = "")
	private String uiiHldSttBssExpln; // 고유식별정보 보유 법령근거
	
	@Schema(description = "개인정보영향평가 대상여부(Y:대상, N:미대상)", example = "")
	private String prvcEvlTrgtYn; // 개인정보영향평가 대상여부(Y:대상, N:미대상)
	
	@Schema(description = "취급담당자", example = "")
	private String hndlPicNm; // 취급담당자
	
	@Schema(description = "제3자 제공받는 자", example = "")
	private String tdptySplrcpNm; // 제3자 제공받는 자
	
	@Schema(description = "제3자 제공 근거", example = "")
	private String tdptyPvsnBssExpln; // 제3자 제공 근거
	
	@Schema(description = "제3자 제공 항목", example = "")
	private String tdptyPvsnMttr; // 제3자 제공 항목
	
	@Schema(description = "개인정보처리 위탁 업체명", example = "")
	private String prvcPrcsCnsgnBzentyNm; // 개인정보처리 위탁 업체명
	
	@Schema(description = "개인정보위탁계약 여부(Y:위탁계약, N:위탁계약 아님)", example = "")
	private String prvcCnsgnCtrtYn; // 개인정보위탁계약 여부(Y:위탁계약, N:위탁계약 아님)
	
	@Schema(description = "개인정보위탁사실 게재여부(Y:게재, N:미게재)", example = "")
	private String prvcCnsgnFactIndctYn; // 개인정보위탁사실 게재여부(Y:게재, N:미게재)
	
	@Schema(description = "목적 외 이용.제공 여부(Y:제공, N:미제공)", example = "")
	private String prpsExclUtztnPvsnYn; // 목적 외 이용.제공 여부(Y:제공, N:미제공)
	
	@Schema(description = "목적 외 이용.제공 근거", example = "")
	private String prpsExclUtztnPvsnBssExpln; // 목적 외 이용.제공 근거
	
	@Schema(description = "등록일자", example = "")
	private Date regYmd; // 등록일자
	
	@Schema(description = "등록자", example = "")
	private String rgtrId; // 등록자
	
	@Schema(description = "수정일자", example = "")
	private Date mdfcnYmd; // 수정일자
	
	@Schema(description = "수정자", example = "")
	private String mdfrId; // 수정자

	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}