package com.taco.main;

import com.taco.tacoEntity.TacoCourseTAAvailability;

public interface TacoService {

    TacoCourseTAAvailability[] getAvailabilityForCourseTAs(String courseName);
}
