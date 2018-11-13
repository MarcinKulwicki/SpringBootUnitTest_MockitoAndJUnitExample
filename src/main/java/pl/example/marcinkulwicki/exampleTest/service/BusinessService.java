package pl.example.marcinkulwicki.exampleTest.service;

import org.springframework.stereotype.Service;
import pl.example.marcinkulwicki.exampleTest.repository.DataService;

@Service
public class BusinessService {

    private DataService dataService;

    public BusinessService(DataService dataService){
        super();
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData(){
        int [] data = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;

        for(int value: data){
            if(value > greatest){
                greatest = value;
            }
        }
        return greatest;
    }

}
