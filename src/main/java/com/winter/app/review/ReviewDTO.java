package com.winter.app.review;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReviewDTO {
	private Long reviewNum;
	private String reviewContents;
	private Long reviewStar;
	private LocalDateTime reviewDate;
	private Long productNum;
	private String username;

}
