package myProject;
import java.io.*;
import java.util.*;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class App {

	public static void main(String[] args) {
		String COMMA_DELIMITER=", ";
		String NEW_LINE_SEPARATOR="\n";
		String FILE_HEADER="Name     , Score";
		ObjectMapper mapper=new ObjectMapper();
        List<Pojo>employees=new ArrayList<Pojo>();
		try {
			Pojo pojo[]=mapper.readValue(new File("https://github.com/Teres1/Project-MentorMate/tree/master/myProject/file.json"),Pojo[].class);
			SecondPojo secondPojo=mapper.readValue(new File("C:\\Users\\Stan\\Desktop\\secondFile.json"), SecondPojo.class);
			double topPerformenceThreshold=secondPojo.getTopPerformersThreshold();
			boolean useExperienceMultiplier=secondPojo.isUseExperienceMultiplier();
			double periodLimit=secondPojo.getPeriodLimit();
			List<Double>scoreWhenExperienceMultiplierIsTrue=new ArrayList<Double>();
			List<Double>scoreWhenExperienceMultiplierIsFalse=new ArrayList<Double>();
			int positionOfTheLastElementWithinX=0;
			for(int i=0;i<pojo.length;i++) {
				employees.add(new Pojo(pojo[i].getName(),pojo[i].getTotalSales(),pojo[i].getSalesPeriod(),pojo[i].getExperienceMultiplier()));
			
				
			}
			if(useExperienceMultiplier) {
				for(Pojo e:employees) {
				scoreWhenExperienceMultiplierIsTrue.add(e.getTotalSales()/e.getSalesPeriod()*e.getExperienceMultiplier());
			}
			}else {
				for(Pojo e:employees) {
					scoreWhenExperienceMultiplierIsFalse.add((double)(e.getTotalSales()/e.getSalesPeriod()));
					
				}
			}
			Collections.sort(scoreWhenExperienceMultiplierIsFalse,Collections.reverseOrder());
			Collections.sort(scoreWhenExperienceMultiplierIsTrue,Collections.reverseOrder());
			positionOfTheLastElementWithinX=(int)(topPerformenceThreshold/100)*employees.size();
			List<FinalEmployee>listFinalEmployees=new ArrayList<FinalEmployee>();
			if(useExperienceMultiplier) {
			for(Pojo e:employees) {
				if((e.getSalesPeriod()<=periodLimit)&&((double)(e.getTotalSales()/e.getSalesPeriod()*e.getExperienceMultiplier())
						>=scoreWhenExperienceMultiplierIsTrue.get(positionOfTheLastElementWithinX))) {
					listFinalEmployees.add(new FinalEmployee(e.getName(),(double)e.getTotalSales()/e.getSalesPeriod()*e.getExperienceMultiplier()));
				}
			}
			}else {
			for(Pojo e:employees) {
				if((e.getSalesPeriod()<=periodLimit)&&((double)(e.getTotalSales()/e.getSalesPeriod())
						>=scoreWhenExperienceMultiplierIsFalse.get(positionOfTheLastElementWithinX))) {
					listFinalEmployees.add(new FinalEmployee(e.getName(),(double)e.getTotalSales()/e.getSalesPeriod()));
				}
			}
			}
			FileWriter fileWriter=new FileWriter("src\\main\\java\\result\\listFinalEmployees.csv");
			fileWriter.append(FILE_HEADER);
			for(FinalEmployee fe:listFinalEmployees) {
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(fe.getName());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(fe.getScore()));
			
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
