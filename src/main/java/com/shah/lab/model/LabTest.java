package com.shah.lab.model;

import javax.persistence.*;

@Entity
@Table(name = "labtest")
public class LabTest
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TST_SEQ")
    @SequenceGenerator(initialValue = 1, sequenceName = "labtest_seq", allocationSize = 1, name = "TST_SEQ")
    private Long sequence;
    private String name;
    private String rangeMin;
    private String rangeMax;
    private String rangeUnit;
    private double price;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRangeMin()
    {
        return rangeMin;
    }

    public void setRangeMin(String rangeMin)
    {
        this.rangeMin = rangeMin;
    }

    public String getRangeMax()
    {
        return rangeMax;
    }

    public void setRangeMax(String rangeMax)
    {
        this.rangeMax = rangeMax;
    }

    public String getRangeUnit()
    {
        return rangeUnit;
    }

    public void setRangeUnit(String rangeUnit)
    {
        this.rangeUnit = rangeUnit;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
