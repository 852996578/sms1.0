package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Survey;
import com.briup.app02.vm.SurveyVM;

public interface ISurveyService {
	
	List<SurveyVM> findAllSurveyVM() throws Exception;

	List<Survey> findAll() throws Exception;
	
	Survey findById(long id) throws Exception;
	
	void save(Survey survey) throws Exception;
	
	void update(Survey survey) throws Exception;
	
	void deleteById(long id) throws Exception;
}
