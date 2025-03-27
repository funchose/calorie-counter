package com.systems.caloriecounter.service;

import com.systems.caloriecounter.CalorieCounterApplication;
import com.systems.caloriecounter.DTO.request.CreateProfileRequest;
import com.systems.caloriecounter.DTO.request.EditProfileRequest;
import com.systems.caloriecounter.repository.ProfileRepository;
import com.systems.caloriecounter.utils.Activity;
import com.systems.caloriecounter.utils.Gender;
import com.systems.caloriecounter.utils.Goal;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalorieCounterApplication.class)
public class ProfileServiceTest {
  @Autowired
  private ProfileService profileService;
  @Autowired
  private ProfileRepository profileRepository;

  @Test
  public void AddProfileKeepWeightTest() {
    var request = new CreateProfileRequest()
        .setName("Ivan")
        .setAge(40)
        .setHeight(180)
        .setWeight(70)
        .setEmail("ivan@mail.ru")
        .setGender(Gender.MALE)
        .setActivity(Activity.HIGH)
        .setGoal(Goal.KEEP_WEIGHT);
    var response = profileService.addProfile(request);
    Assertions.assertEquals(2868, response.getCalorieNorm());
  }
  @Test
  public void AddProfileGainWeightTest() {
    var request = new CreateProfileRequest()
        .setName("Andrew")
        .setAge(50)
        .setHeight(175)
        .setWeight(75)
        .setEmail("andrew@mail.ru")
        .setGender(Gender.MALE)
        .setActivity(Activity.HIGH)
        .setGoal(Goal.GAIN_WEIGHT);
    var response = profileService.addProfile(request);
    Assertions.assertEquals(3143, response.getCalorieNorm());
  }
  @Test
  public void AddProfileLoseWeightTest() {
    var request = new CreateProfileRequest()
        .setName("Alina")
        .setAge(30)
        .setHeight(165)
        .setWeight(80)
        .setEmail("alina@mail.ru")
        .setGender(Gender.FEMALE)
        .setActivity(Activity.MEDIUM)
        .setGoal(Goal.LOSE_WEIGHT);
    var response = profileService.addProfile(request);
    Assertions.assertEquals(2127, response.getCalorieNorm());
  }
  @Test
  public void EditProfileTest() {
    var request = new EditProfileRequest()
        .setWeight(70)
        .setGoal(Goal.KEEP_WEIGHT);
    var response = profileService.editProfile(profileRepository
        .findByEmail("alina@mail.ru").getId(), request);
    Assertions.assertEquals(2285, response.getCalorieNorm());
  }

}
