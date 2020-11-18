package io.github.lvgocc.composite.decision;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DecisionCompositeTest {

    private static Logger logger = LoggerFactory.getLogger(DecisionCompositeTest.class);
    private static DecisionComponent decisionComposite;

    @BeforeAll
    void init() {
        /*
            构建决策树
         */
        decisionComposite = new DecisionComposite("用户信息");
        DecisionComponent genderMale = new DecisionGenderMale("性别男");
        DecisionComponent genderFeMale = new DecisionGenderFeMale("性别女");

        decisionComposite.add(genderMale);
        decisionComposite.add(genderFeMale);

        DecisionComponent ageAmong20and30 = new DecisionAgeAmong20and30("20-30年龄之间");
        DecisionComponent ageAmong30and40 = new DecisionAgeAmong30and40("30-40年龄之间");
        DecisionComponent ageLess20 = new DecisionAgeLess20("小于20岁");
        DecisionComponent ageThan40 = new DecisionAgeThan40("大于40岁");

        genderMale.add(ageAmong20and30);
        genderMale.add(ageAmong30and40);
        genderMale.add(ageLess20);
        genderMale.add(ageThan40);

        ageLess20.add(new DecisionResult("决策结果", "玩具"));
        ageAmong30and40.add(new DecisionResult("决策结果", "枸杞"));
    }

    @Test
    void decision() {
        User user = new User(Gender.MALE, 35);
        DecisionComponent decisionResult = decisionComposite.decision(user);
        logger.info("决策结果：{}", decisionResult);
    }
}