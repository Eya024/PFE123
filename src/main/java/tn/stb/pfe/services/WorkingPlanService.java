package tn.stb.pfe.services;

import tn.stb.pfe.models.WorkingPlan;
import tn.stb.pfe.models.user.provider.Provider;
import tn.stb.pfe.models.TimePeroid;

public interface WorkingPlanService {
    void updateWorkingPlan(WorkingPlan workingPlan);

    void addBreakToWorkingPlan(TimePeroid breakToAdd, int planId, String dayOfWeek);

    void deleteBreakFromWorkingPlan(TimePeroid breakToDelete, int planId, String dayOfWeek);

    WorkingPlan getWorkingPlanByProviderId(int providerId);

    

    public void generateAndSaveWorkingPlanForProvider(Provider provider) ;
}
