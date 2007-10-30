/*
 * This file is part of the Alitheia system, developed by the SQO-OSS
 * consortium as part of the IST FP6 SQO-OSS project, number 033331.
 *
 * Copyright 2007 by the SQO-OSS consortium members <info@sqo-oss.eu>
 * Copyright 2007 Georgios Gousios <gousiosg@aueb.gr>
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *     * Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials provided
 *       with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package eu.sqooss.metrics.abstractmetric;

import eu.sqooss.service.db.ProjectVersion;

/**
 * A metric plug-in implements the <tt>ProjectVersionMetric</tt> interface to
 * indicate that its results are linked to the ProjectVersion table, and 
 * consequently needs to be recalculated on every new project version. 
 */
public interface ProjectVersionMetric {

    /**
     * Run the metric to update the metric results when new versions
     * of the evaluated project are available. 
     * 
     * By default, the run method will start updating metric results from
     * <tt>a</tt> to <tt>b</tt>.
     *   
     * @param The first new version DAO
     * @param The last new version DAO
     * @return True, if the metric run succesfuly, false otherwise
     * @see eu.sqooss.service.db.ProjectVersion
     */
    boolean run(ProjectVersion a, ProjectVersion b);

    /**
     * Return results 
     * 
     * @param The project version to return results for
     * @return A {@link MetricResult} object when results for this version
     * exist, <tt>null</tt> otherwise.
     */
    MetricResult getResult(ProjectVersion a);

    /**
     * Delete all results for project version <tt>a</tt>
     * 
     * @param The project version to delete results for
     * @return True if clean up succeeded false otherwise
     */
    boolean delete(ProjectVersion a);
}
