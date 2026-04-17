package com.winter.app.pager;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Pager {
	
	//페이지 번호
	private Long page;
	//페이지당 보여줄 글의 개수
	private Long perPage;
	//offset 번호
	private Long startNum;
	//검색어
	private String search = "";
	//검색컬럼
	private String kind; //v1이면 title, v2이면 contents, v3이면 writer
	//각 블럭의 시작번호
	private Long start;
	//각 블럭의 끝번호
	private Long end;
	//이전 블럭 유무
	private boolean pre = true;
	//다음 블럭 유무
	private boolean next = true;
	
	
	public Long getPage() {
		if(page==null || page<1) {
			this.page=1L;
		}
		return this.page;
	}
	
	public Long getPerPage() {
		if(perPage==null || perPage<1) {
			this.perPage=5L;
		}
		return this.perPage;
	}
	
	public void makeStartNum() {
		this.startNum = (this.getPage()-1)*getPerPage();
	}
	
	public void makePageNum(Long totalCount) {
		//1. 총 페이지 수 구하기
		Long totalPage = (long)(Math.ceil((double)totalCount / getPerPage()));
		
		//2. 총 블럭 수 구하기
		Long perBlock = 5L;
		Long totalBlock = totalPage/perBlock;
		if(totalPage%5 != 0) {
			totalBlock++;
		}
		
		//3. 페이지 번호로 현재 블럭 번호 구하기
		Long curBlock = getPage()/perBlock;
		if(getPage()%perBlock != 0) {
			curBlock++;
		}
		
		//4. 현재 블럭 번호로 시작번호와 끝번호 구하기
		start = (curBlock-1)*perBlock+1;
		end = curBlock*perBlock;
		
		//5. 현재 블럭 번호가 총 블럭과 같다면
		if(curBlock==totalBlock) {
			end = totalPage;
			next = false;
		}
		
		//6. 이전 블럭 유무
		if(curBlock==1) {
			pre = false;
		}
		
	}
	
	
	

}
