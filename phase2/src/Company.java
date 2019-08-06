import java.util.ArrayList;

public class Company {

    private HR_Coordinator hrCoordinator;
    private ArrayList<JobPosting> jobPostings;
    private ArrayList<Interviewer> interviewers;
    private String companyName;

    public Company(String companyName, HR_Coordinator hrCoordinator){
        this.hrCoordinator = hrCoordinator;
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public void setHrCoordinator(HR_Coordinator hrCoordinator){ this.hrCoordinator = hrCoordinator; }

    public void addInterviewer(Interviewer interviewer) { this.interviewers.add(interviewer); }

    HR_Coordinator getHrCoordinator(){ return this.hrCoordinator; }
}