/*
 * The MIT License
 * 
 * Copyright (c) 2012-2013 IKEDA Yasuyuki
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jp.ikedam.jenkins.plugins.jobcopy_builder;

import java.io.Serializable;

import hudson.model.TopLevelItem;
import hudson.model.Action;

/**
 * Action holds the information of the jobs that the build copied from and to.
 * 
 * the information will be shown in the build's Summary page,
 * using summary.jelly.
 * 
 */
public class CopiedjobinfoAction implements Action, Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String fromJobName;
    
    /**
     * Returns the name of the job copied from.
     * 
     * @return the name of the job copied from
     */
    public String getFromJobName()
    {
        return this.fromJobName;
    }
    
    public String fromUrl;
    
    /**
     * Returns the URI (path) of the job copied from.
     * 
     * This URI might be lost,
     * in the case that the job is removed or renamed.
     * 
     * @return the URI (path) of the job copied from.
     */
    public String getFromUrl()
    {
        return this.fromUrl;
    }
    
    public String toJobName;
    
    /**
     * Returns the name of the job copied to.
     * 
     * @return the name of the job copied to
     */
    public String getToJobName()
    {
        return this.toJobName;
    }
    
    public String toUrl;
    
    /**
     * Returns the URI (path) of the job copied to.
     * 
     * This URI might be lost,
     * in the case that the job is removed or renamed.
     * 
     * @return the URI (path) of the job copied to.
     */
    public String getToUrl()
    {
        return this.toUrl;
    }
    
    /**
     * 
     * constructor.
     * 
     * @param fromItem  job that was copied from.
     * @param toItem    job that was copied to.
     */
    public CopiedjobinfoAction(TopLevelItem fromItem, TopLevelItem toItem)
    {
        this.fromJobName = fromItem.getName();
        this.fromUrl = fromItem.getUrl();
        this.toJobName = toItem.getName();
        this.toUrl = toItem.getUrl();
    }
    
    /**
     * Returns null not for being displayed in the link list.
     * 
     * @return null
     * @see hudson.model.Action#getIconFileName()
     */
    @Override
    public String getIconFileName()
    {
       return null;
    }
    
    /**
     * Returns null not for being displayed in the link list.
     * 
     * @return null
     * @see hudson.model.Action#getUrlName()
     */
    @Override
    public String getUrlName()
    {
        return null;
    }
    
    /**
     * Returns the display name.
     * 
     * This will be never used, for not displayed in the link list.
     * 
     * @return the display name.
     * @see hudson.model.Action#getDisplayName()
     */
    @Override
    public String getDisplayName()
    {
        return Messages.CopiedjobinfoAction_DisplayName();
    }
}
