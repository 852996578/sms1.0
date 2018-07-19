package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Option;
import com.briup.app02.bean.Question;
import com.briup.app02.dao.OptionMapper;
import com.briup.app02.dao.QuestionMapper;
import com.briup.app02.dao.extend.QuestionVMMapper;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.vm.QuestionVM;

@Service
public class QuestionServiceImpl implements IQuestionService{

	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionMapper optionMapper;
	

	@Override
	public List<Question> findAll() throws Exception {
		//调用studnetMapper查询所有学生
		List<Question> list = questionMapper.findAll();
		return list;
	}

	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		List<QuestionVM> list = questionVMMapper.findAllQuestionVM();
		return list;
	}

	@Override
	public Question findById(long id) throws Exception{
		//通过id查询某个学生
		return questionMapper.findById(id);
	}
	
	@Override
	public void save(Question question) throws Exception{
		//插入学生信息
		questionMapper.save(question);
	}
	
	
	@Override
	public void update(Question question) throws Exception{
		//修改学生信息
		questionMapper.update(question);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// 1. 通过id查找
		Question question = questionMapper.findById(id);
		// 2. 如果该学生存在，执行删除操作，如果该学生不存在，抛出异常
		if (question != null) {
			questionMapper.deleteById(id);
		} else {
			throw new Exception("要删除的 不存在");
		}
	}

	@Override
	public void saveQuestion(QuestionVM questionVM) throws Exception {
		// TODO Auto-generated method stub
		// 一对多怎么写？？？
		/*
		 * 1. 将question和option 从questionVM 中剥离出来 2. question ,List<Option>
		 * options 3. 调用QuestionMapper.save(question) 4. 获取刚刚保存的question的id 5.
		 * 将所有的选项的外检设置为刚刚获取到question的id for(Option option : list){
		 * option.setQuestionId(id) OptionMapper.save(option); }
		 */
		// 1. 剥离出来question option
		Long questionId = questionVM.getId();  // 肯定null
		String questionName = questionVM.getName();
		String questionType = questionVM.getQuestiontype();
		Question question = new Question(questionId, questionName, questionType);
		List<Option> options = questionVM.getOptions();
		// 2. 保存问题
		questionMapper.save(question);
		// 3. 获取刚刚保存问题的id //可能不是null
		Long question_id = question.getId();

		System.out.println("============" + question_id);
		// 4. 保存选项
		for (Option option : options) {
			option.setQuestion_id(question_id);
			optionMapper.save(option);
		}
	}
}
