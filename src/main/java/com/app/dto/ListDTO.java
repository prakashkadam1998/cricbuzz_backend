package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.entity.Inning;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ListDTO {

	List<String> list = new ArrayList<String>();
}
