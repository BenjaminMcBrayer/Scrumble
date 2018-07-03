package com.gc.scrumble.oops.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * @author Ben McBrayer, Brent Coppinger, Victoria Rush
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Word {
	
	@JsonProperty("totalResults")
	private Long count;

	public Word() {
		
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Word count: " + count;
	}
	
	

}
