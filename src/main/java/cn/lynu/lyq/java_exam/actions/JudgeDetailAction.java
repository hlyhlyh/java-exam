package cn.lynu.lyq.java_exam.actions;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.lynu.lyq.java_exam.dao.BankQuestionDao;
import cn.lynu.lyq.java_exam.entity.BankJudgeQuestion;

@Component("judgeDetail")
@Scope("prototype")
public class JudgeDetailAction extends ActionSupport {
	
	private static final long serialVersionUID = 1320414130188344435L;
	private BankJudgeQuestion question;
	@Resource 
	private BankQuestionDao bankQuestionDao;
	
	public BankJudgeQuestion getQuestion() {
		return question;
	}
	public void setQuestion(BankJudgeQuestion question) {
		this.question = question;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String qid = ctx.getParameters().get("qid").getValue();
		question = bankQuestionDao.findJudgeById(Integer.parseInt(qid.trim()));
		
		return SUCCESS;
	}
	
}