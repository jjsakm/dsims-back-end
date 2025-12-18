package egovframework.com.edoc.clsf.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.ResponseCode;
import egovframework.com.cmm.service.ResultVO;
import egovframework.com.cmm.util.ResultVoHelper;
import egovframework.com.edoc.clsf.service.impl.DocumentClassificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "documentclassification")
@RequiredArgsConstructor
@Tag(name = "DocumentClassificationController", description = "회원 관리")
public class DocumentClassificationController {

	public static final String HEADER_STRING = "Authorization";

	private final ResultVoHelper resultVoHelper;
	private final DocumentClassificationService documentClassificationService;

	@Operation(summary = "대분류 조회", description = "대분류 조회", tags = { "DocumentClassificationController" })
	@GetMapping("/toplevel")
	public ResultVO getAllOfOption() {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("list", documentClassificationService.getTopLevelList());

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	@Operation(summary = "하위분류 조회", description = "하위분류 조회", tags = { "DocumentClassificationController" })
	@Parameters({ @Parameter(name = "no", description = "문서분류코드 번호", required = true) })
	@GetMapping("/{no}/children")
	public ResultVO getAllOfOption(@PathVariable("no") String no) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("list", documentClassificationService.getChildren(no));

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	/*
	 * @Operation( summary = "문서분류 목록 조회", description = "문서분류 목록을 조회", tags =
	 * {"DocumentClassificationController"} )
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(responseCode = "200", description = "조회 성공") })
	 * 
	 * @GetMapping(value = "/") public IntermediateResultVO<ListResponseDTO>
	 * selectDocumentClassificationList(@ModelAttribute BbsSearchRequestDTO
	 * bbsSearchRequestDTO,
	 * 
	 * @Parameter(hidden = true) @AuthenticationPrincipal LoginVO user) throws
	 * Exception { BbsFileAtchResponseDTO attributeDetailResponse =
	 * bbsAttrbService.selectBBSMasterInf(bbsSearchRequestDTO.getBbsId(),
	 * user.getUniqId(), BbsDetailRequestType.DETAIL);
	 * 
	 * PaginationInfo paginationInfo = new PaginationInfo();
	 * paginationInfo.setCurrentPageNo(bbsSearchRequestDTO.getPageIndex());
	 * paginationInfo.setRecordCountPerPage(propertyService.getInt(
	 * "Globals.pageUnit"));
	 * paginationInfo.setPageSize(propertyService.getInt("Globals.pageSize"));
	 * 
	 * ListResponseDTO response =
	 * bbsMngService.selectBoardArticles(bbsSearchRequestDTO, paginationInfo, "");
	 * paginationInfo.setTotalRecordCount(response.getResultCnt());
	 * response.setPaginationInfo(paginationInfo); response.setUser(user);
	 * response.setBrdMstrVO(attributeDetailResponse);
	 * 
	 * return IntermediateResultVO.success(response); }
	 */

}