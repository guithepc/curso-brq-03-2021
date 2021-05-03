package br.com.brq.camel.covid;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DataCovidModel {

	private List<UfCovidModel> data = new ArrayList<UfCovidModel>();
}