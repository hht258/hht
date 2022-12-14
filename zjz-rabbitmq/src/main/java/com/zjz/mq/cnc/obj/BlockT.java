package com.zjz.mq.cnc.obj;

import lombok.Data;

/**
 * @author zjz
 * @date 2022/8/5 16:36
 */
@Data
public class BlockT {

    // Fields used by the bresenham algorithm for tracing the line
    // 方向控制 1：正  0：负
    private int directionBits;            // The direction bit set for this block (refers to *_DIRECTION_BIT in config.h)
    private int stepsX, stepsY, stepsZ; // Step count along each axis    58-X 59-Y 5A-Z      沿每个轴的步数
    private int stepEventCount;          // 完成此块所需的最大步骤事件数

    // Fields used by the motion planner to manage acceleration
    private float nominalSpeed;               // The nominal speed for this block in mm/min 此块的标称速度，单位为 mm/min
    private float entrySpeed;                 // Entry speed at previous-current block junction in mm/min 前一个当前块连接处的进入速度，单位为 mm/min
    private float maxEntrySpeed;             // Maximum allowable junction entry speed in mm/min 最大允许结点进入速度，单位为 mm/min
    private float millimeters;                 // The total travel of this block in mm 该块的总行程，单位为 mm
    private Boolean recalculateFlag;           // Planner flag to recalculate trapezoids on entry junction 用于重新计算入口交界处梯形的规划器标志
    private Boolean nominalLengthFlag;        // Planner flag for nominal speed always reached 始终达到标称速度的规划器标志

    // Settings for the trapezoid generator
    private int initialRate;              // The step rate at start of block   梯形中间开始的速率
    private int finalRate;                // The step rate at end of block  块结束时的步率
    private int rateDelta;                 // 改变速度时要加减的步数/分钟(必须是正的)
    private int accelerateUntil;          // 停止加速度的阶跃事件的索引
    private int decelerateAfter;          // 开始减速的阶跃事件的索引
    private int nominalRate;              // 此块的名义步进速率，单位为 step_events/分钟

    @Override
    public String toString() {
        return
                "directionBits=" + this.directionBits + "" + ", " +
                "stepsX=" + this.stepsX + "" + ", " +
                "stepsY=" + this.stepsY + "" + ", " +
                "stepsZ=" + this.stepsZ + "" + ", " +
                "stepEventCount=" + this.stepEventCount + "" + ", " +
                "nominalSpeed=" + this.nominalSpeed + "" + ", " +
                "entrySpeed=" + this.entrySpeed + "" + ", " +
                "maxEntrySpeed=" + this.maxEntrySpeed + "" + ", " +
                "millimeters=" + this.millimeters + "" + ", " +
                "recalculateFlag=" + this.recalculateFlag + "" + ", " +
                "nominalLengthFlag=" + this.nominalLengthFlag + "" + ", " +
                "initialRate=" + this.initialRate + "" + ", " +
                "finalRate=" + this.finalRate + "" + ", " +
                "rateDelta=" + this.rateDelta + "" + ", " +
                "accelerateUntil=" + this.accelerateUntil + "" + ", " +
                "decelerateAfter=" + this.decelerateAfter + "" + ", " +
                "nominalRate=" + this.nominalRate;
    }
}
