package egovframework.com.edoc.clsf.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.ResponseCode;
import egovframework.com.cmm.service.ResultVO;
import egovframework.com.cmm.util.ResultVoHelper;
import egovframework.com.edoc.clsf.dto.request.DocClsfInsertRequestDto;
import egovframework.com.edoc.clsf.dto.request.DocClsfSearchRequestDto;
import egovframework.com.edoc.clsf.dto.request.DocClsfUpdateRequestDto;
import egovframework.com.edoc.clsf.dto.request.PrvcFileHldPrstUpsertRequestDto;
import egovframework.com.edoc.clsf.service.impl.DocClsfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "documentclassification")
@RequiredArgsConstructor
@Tag(name = "DocClsfController", description = "문서분류")
public class DocClsfController {

	public static final String HEADER_STRING = "Authorization";

	private final EgovPropertyService propertyService;
	private final ResultVoHelper resultVoHelper;
	private final DocClsfService docClsfService;

	@Operation(summary = "대분류 조회", description = "대분류 조회", tags = { "DocClsfController" })
	@GetMapping("/toplevel")
	public ResultVO getTopLevel() {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("list", docClsfService.getTopLevelList());

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	@Operation(summary = "하위분류 조회", description = "하위분류 조회", tags = { "DocClsfController" })
	@Parameters({ @Parameter(name = "docClsfNo", description = "문서분류코드 번호", required = true) })
	@GetMapping("/{docClsfNo}/children")
	public ResultVO getChildren(@PathVariable("docClsfNo") String docClsfNo) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("list", docClsfService.getChildren(docClsfNo));

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	@Operation(summary = "문서분류 상세 조회", description = "문서분류 상세 조회", tags = { "DocClsfController" })
	@Parameters({ @Parameter(name = "docClsfNo", description = "문서분류코드 번호", required = true) })
	@GetMapping("/{docClsfNo}")
	public ResultVO get(@PathVariable("docClsfNo") String docClsfNo) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("detail", docClsfService.select(docClsfNo));

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	@Operation(summary = "문서분류 목록 조회", description = "문서분류 목록을 조회", security = {
			@SecurityRequirement(name = "Authorization") }, tags = { "DocClsfController" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "조회 성공"),
			@ApiResponse(responseCode = "403", description = "인가된 사용자가 아님") })

	@GetMapping(value = "/search")
	public ResultVO selectBBSUseInfs(HttpServletRequest request,
			@ModelAttribute DocClsfSearchRequestDto searchRequestDto) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		searchRequestDto.setPageUnit(propertyService.getInt("Globals.pageUnit"));
		searchRequestDto.setPageSize(propertyService.getInt("Globals.pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(searchRequestDto.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchRequestDto.getPageUnit());
		paginationInfo.setPageSize(searchRequestDto.getPageSize());

		searchRequestDto.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchRequestDto.setLastIndex(paginationInfo.getLastRecordIndex());
		searchRequestDto.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		paginationInfo.setTotalRecordCount(docClsfService.selectListTotCnt(searchRequestDto));

		resultMap.put("list", docClsfService.selectList(searchRequestDto));
		resultMap.put("paginationInfo", paginationInfo);

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	@Operation(summary = "문서분류 등록", description = "문서 등록 등록처리", security = {
			@SecurityRequirement(name = "Authorization") }, tags = { "DocClsfController" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "등록 성공"),
			@ApiResponse(responseCode = "403", description = "인가된 사용자가 아님"),
			@ApiResponse(responseCode = "900", description = "입력값 무결성 오류") })
	@PostMapping("/add")
	public ResultVO insertClsf(@RequestBody DocClsfInsertRequestDto docClsfInsertRequestDto,
			BindingResult bindingResult) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		if (bindingResult.hasErrors()) {

			resultMap.put("resultMsg", "등록 실패");
			return resultVoHelper.buildFromMap(resultMap, ResponseCode.SAVE_ERROR);
		}

		docClsfInsertRequestDto.setRgtrId("tester");
		docClsfInsertRequestDto.setMdfrId("tester");
		PrvcFileHldPrstUpsertRequestDto prvcFieldHldPrst = docClsfInsertRequestDto.getPrvcFileHldPrst();
		if (prvcFieldHldPrst != null) {
			prvcFieldHldPrst.setRgtrId("tester");
			prvcFieldHldPrst.setMdfrId("tester");
		}

		docClsfService.insert(docClsfInsertRequestDto);

		resultMap.put("docClsfNo", docClsfInsertRequestDto.getDocClsfNo());
		resultMap.put("resultMsg", "success.common.insert");

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	@Operation(summary = "문서분류 수정", description = "문서 수정 처리", security = {
			@SecurityRequirement(name = "Authorization") }, tags = { "DocClsfController" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "수정 성공"),
			@ApiResponse(responseCode = "403", description = "인가된 사용자가 아님"),
			@ApiResponse(responseCode = "900", description = "입력값 무결성 오류") })
	@PostMapping("/update")
	public ResultVO updateClsf(@RequestBody DocClsfUpdateRequestDto docClsfUpdateRequestDto,
			BindingResult bindingResult) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		if (bindingResult.hasErrors()) {

			resultMap.put("resultMsg", "수정 실패");
			return resultVoHelper.buildFromMap(resultMap, ResponseCode.SAVE_ERROR);
		}

		docClsfUpdateRequestDto.setMdfrId("tester");
		PrvcFileHldPrstUpsertRequestDto prvcFieldHldPrst = docClsfUpdateRequestDto.getPrvcFileHldPrst();
		if (prvcFieldHldPrst != null) {
			prvcFieldHldPrst.setMdfrId("tester");
		}

		docClsfService.update(docClsfUpdateRequestDto);

		resultMap.put("docClsfNo", docClsfUpdateRequestDto.getDocClsfNo());
		resultMap.put("resultMsg", "success.common.insert");

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	@Operation(summary = "문서분류 삭제", description = "문서분류를 삭제 처리", security = {
			@SecurityRequirement(name = "Authorization") }, tags = { "DocClsfController" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "삭제 성공"),
			@ApiResponse(responseCode = "403", description = "인가된 사용자가 아님") })
	@DeleteMapping(value = "/{docClsfNo}/delete")
	public ResultVO delete(@PathVariable("docClsfNo") String docClsfNo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		docClsfService.delete(docClsfNo);
		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}
}