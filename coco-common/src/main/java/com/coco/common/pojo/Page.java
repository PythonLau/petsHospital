package com.coco.common.pojo;
import java.util.List;

/**
 * Created by Administrator on 2017/3/25 0025.
 */
public class Page<T> {

    public static final int PAGE_SIZE = 8;

    private int currentPageNo;
    private List<T> list;
    private int pageSize = PAGE_SIZE;
    private long totalPageItems;

    public Page(int pageNo) {
        this.currentPageNo = pageNo;
    }

    /**
     * 设置页大小，默认 pageSize = PAGE_SIZE
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取当前的页码，而且确保当前的页码不越界
     * @return
     */
    public int getCurrentPageNo() {
        if (currentPageNo < 0)
            currentPageNo = 1;

        if (currentPageNo > getTotalPageNumber())
            currentPageNo = getTotalPageNumber();

        return currentPageNo;
    }


    /**
     * 获取页大小
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * 获取总的页码
     * @return
     */
    public int getTotalPageNumber() {
        int totalPageNumber = (int) (totalPageItems / pageSize);
        if (totalPageItems % pageSize != 0)
            totalPageNumber++;
        return totalPageNumber;
    }

    /**
     * 设置总的页项
     * @param totalPageItems
     */
    public void setTotalPageItems(long totalPageItems) {
        this.totalPageItems = totalPageItems;
    }

    /**
     * 是否有下一页
     * @return
     */
    public boolean isHasNext() {
        if (getCurrentPageNo() < getTotalPageNumber())
            return true;

        System.out.println(getCurrentPageNo() + ":" + getTotalPageNumber());
        return false;
    }

    /**
     * 是否有前一页
     * @return
     */
    public boolean isHasPrev() {
        if (getCurrentPageNo() > 1)
            return true;
        return false;
    }

    /**
     * 获取下一页
     * @return
     */
    public int getNextPage() {
        if (isHasNext())
            return getCurrentPageNo() + 1;
        return currentPageNo;
    }

    /**
     * 获取前一页
     * @return
     */
    public int getPrevPage() {
        if (isHasPrev())
            return getCurrentPageNo() - 1;
        return currentPageNo;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPageNo=" + currentPageNo +
                ", list=" + list +
                ", pageSize=" + pageSize +
                ", totalPageItems=" + totalPageItems +
                '}';
    }
}

