import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Mohit {
	private class Education implements Comparable<Education> {
		private enum EducationLevel {
			PHD, MASTER, BACHELOR, NONE; 
		}
		
		public EducationLevel level;
		public String field;
		
		public Education(String level, String field) {
			this.field = field;
			switch(level) {
				case "PhD": {
					this.level = EducationLevel.PHD;
					break;
				}
				case "Master's": {
					this.level = EducationLevel.MASTER;
					break;
				}
				case "Bachelor's": {
					this.level = EducationLevel.BACHELOR;
					break;
				}
				default: {
					this.level = EducationLevel.NONE;
					break;
				}
			}
		}
		
		public int compareTo(Education other) {
			return Integer.compare(this.level.ordinal(), other.level.ordinal());
		}
		
		public boolean isQualified(Education standard) {
			if(standard.level == EducationLevel.NONE) {
				return true;
			} else if(!this.field.equals(standard.field)) {
				return false;
			} else if(this.level.ordinal() > standard.level.ordinal()) {
				return false;
			}
			return true;
		}
		
		public String toString() {
			return String.format("Education: %s", this.level.toString());
		}
	}
	
	private class Skills {
		public HashMap<String, Integer> skillToYears;
		
		public Skills(HashMap<String, Integer> skillToYears) {
			this.skillToYears = skillToYears;
		}
		
		public boolean isQualified(Skills standard) {
			for(String skill : standard.skillToYears.keySet()) {
				if(!this.skillToYears.containsKey(skill)) {
					return false;
				} else if(this.skillToYears.get(skill) < standard.skillToYears.get(skill)) {
					return false;
				}
			}
			return true;
		}
		
		public String toString() {
			return String.format("Skills: %s", this.skillToYears.toString());
		}
	}
	
	private class Awards {
		public HashSet<String> awards;
		
		public Awards(HashSet<String> awards) {
			this.awards = awards;
		}
		
		public boolean isQualified(Awards standard) {
			for(String award : standard.awards) {
				if(!this.awards.contains(award)) {
					return false;
				}
			}
			return true;
		}
		
		public String toString() {
			return String.format("Awards: %s", this.awards.toString());
		}
	}
	
	private class Applicant {
		public String name;
		public Education education;
		public Skills skills;
		public Awards awards;
		
		public Applicant(String name, Education education, Skills skills, Awards awards) {
			this.name = name;
			this.education = education;
			this.skills = skills;
			this.awards = awards;
		}
		
		public boolean isQualified(Applicant standard) {
			return education.isQualified(standard.education) && skills.isQualified(standard.skills) && awards.isQualified(standard.awards);
		}
		
		public String toString() {
			return String.format("Name: %s\n%s\n%s\n%s", name, education.toString(), skills.toString(), awards.toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Mohit().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(file.readLine());
		
		int numApplicants = Integer.parseInt(st.nextToken());
		int numJobs = Integer.parseInt(st.nextToken());
		
		Applicant[] applicants = new Applicant[numApplicants];
		Applicant[] jobs = new Applicant[numJobs];
		
		for(int i = 0; i < numApplicants; i++) {
			List<List<String>> brokenDown = Arrays.asList(file.readLine().split(";")).stream().map(str -> str.split(",")).map(arr -> Arrays.asList(arr).stream().toList()).toList();
			
			String temp = brokenDown.get(1).get(0);
			Education education;
			if(temp.equals("Education: None")) {
				education = new Education("None", null);
			} else {
				temp = temp.substring(temp.indexOf(':') + 2);
				education = new Education(temp.substring(0, temp.indexOf(' ')), temp.substring(temp.indexOf("of")+3));
			}
			
			HashMap<String, Integer> skillMap = new HashMap<String, Integer>();
			if(!brokenDown.get(2).get(0).equals("None")) {
				brokenDown.get(2).stream().forEach(str -> {
					String[] tempArr = str.split(": ");
					skillMap.put(tempArr[0].substring(1), Integer.parseInt(tempArr[1].substring(0, tempArr[1].indexOf(' '))));
				});
			}
			Skills skills = new Skills(skillMap);
			
			HashSet<String> awardsSet = new HashSet<String>();
			if(!brokenDown.get(3).get(0).equals(" Awards: None")) {
				awardsSet.add(brokenDown.get(3).get(0).substring(9));
				for(int j = 1; j < brokenDown.get(3).size(); j++) {
					awardsSet.add(brokenDown.get(3).get(j).substring(1));
				}
			}
			Awards awards = new Awards(awardsSet);
			
			applicants[i] = new Applicant(brokenDown.get(0).get(0).substring(6), education, skills, awards);
		}
		
		for(int i = 0; i < numJobs; i++) {
			List<List<String>> brokenDown = Arrays.asList(file.readLine().split(";")).stream().map(str -> str.split(",")).map(arr -> Arrays.asList(arr).stream().toList()).toList();
			
			String temp = brokenDown.get(1).get(0);
			temp = temp.substring(temp.indexOf(':') + 2);
			Education education = new Education(temp.substring(0, temp.indexOf(' ')), temp.substring(temp.indexOf("of")+3));
			
			HashMap<String, Integer> skillMap = new HashMap<String, Integer>();
			if(!brokenDown.get(2).get(0).equals("None")) {
				brokenDown.get(2).stream().forEach(str -> {
					String[] tempArr = str.split(": ");
					skillMap.put(tempArr[0].substring(1), Integer.parseInt(tempArr[1].substring(0, tempArr[1].indexOf(' '))));
				});
			}
			Skills skills = new Skills(skillMap);
			
			HashSet<String> awardsSet = new HashSet<String>();
			if(!brokenDown.get(3).get(0).equals(" None")) {
				awardsSet.add(brokenDown.get(3).get(0).substring(1));
				for(int j = 1; j < brokenDown.get(3).size(); j++) {
					awardsSet.add(brokenDown.get(3).get(j).substring(1));
				}
			}
			Awards awards = new Awards(awardsSet);
			
			jobs[i] = new Applicant(brokenDown.get(0).get(0).substring(5), education, skills, awards);
		}
		
		for(Applicant job : jobs) {
			List<Applicant> qualified = Arrays.asList(applicants).stream().filter(applicant -> applicant.isQualified(job)).collect(Collectors.toList());
			
			Comparator<Applicant> compare = (applicant1, applicant2) -> {
				int comp = applicant1.education.compareTo(applicant2.education);
				if(comp != 0) {
					return comp;
				}
				int s1 = 0, s2 = 0;
				for(String skill : job.skills.skillToYears.keySet()) {
					s1 += applicant1.skills.skillToYears.get(skill) - job.skills.skillToYears.get(skill);
					s2 += applicant2.skills.skillToYears.get(skill) - job.skills.skillToYears.get(skill);
				}
				comp = -1 * Integer.compare(s1, s2);
				if(comp != 0) {
					return comp;
				}
				return applicant1.name.compareTo(applicant2.name);
			};
			Collections.sort(qualified, compare);
			
			out.println(String.format("%s:", job.name));
			for(int i = 0; i < Math.min(qualified.size(), 3); i++) {
				out.println(String.format("%d: %s", (i+1), qualified.get(i).name));
			}
			out.println();
		}
		
		file.close();
		out.close();
	}
}
