package com.zhiyou100.oop.day11;

/**
 * @packageName: javase_26
 * @className: Pdf07OfDome02
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/15 10:02 上午
 */
public class Pdf07OfDemo02 {
}

abstract class Role {
    /**
     * @name: Role
     * @param:
     * @description: TODO   所有职业的父类
     * @date: 2020/2/15 10:07 上午
     * @return:
     */
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract public int attack();
    /**
     * @name: attack
     * @param:
     * @description: TODO 角色的攻击对敌人的伤害
     * @date: 2020/2/15 10:07 上午
     * @return: int
     */


}

class Magicer extends Role {
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Magicer(String name, int level) {
        super(name);
        this.level = level;
    }

    /**
     * @name: Magicer
     * @param:
     * @description: TODO  魔法师类
     * @date: 2020/2/15 10:06 上午
     * @return:
     */
    private int level;

    @Override
    public int attack() {
        /**
         * @name: attack
         * @param: 无
         * @description: TODO 伤害 = 魔法等级 * 5
         * @date: 2020/2/15 10:05 上午
         * @return:
         */
        return level * 5;
    }
}

class Soldier extends Role {
    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public Soldier(String name, int hurt) {
        super(name);
        this.hurt = hurt;
    }

    /**
     * @name: Soldier
     * @param:
     * @description: TODO 战士
     * @date: 2020/2/15 10:08 上午
     * @return:
     */
    private int hurt;

    @Override
    public int attack() {
        /**
         * @name: attack
         * @param:
         * @description: TODO 伤害 = hurt
         * @date: 2020/2/15 10:08 上午
         * @return:
         */
        return hurt;
    }
}
class Team{
    void addMember(Role role){
        Role[] role1 = new Role[6];
        for (int i = 0; i < role1.length; i++) {
            role1[i]=role;
        }
    }

    public Team() {
    }

    int attackSum(Role role){
        int attack=0;
        Role[] role1 = new Role[6];
        for (int i = 0; i < role1.length; i++) {
            role1[i]=role;
        }
        for (int i = 0; i < role1.length; i++) {
            attack+=role1[i].attack();
        }
        return attack;
    }
}