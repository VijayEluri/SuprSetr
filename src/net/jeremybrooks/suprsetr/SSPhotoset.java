/*
 * SuprSetr is Copyright 2010 by Jeremy Brooks
 *
 * This file is part of SuprSetr.
 *
 *  SuprSetr is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  SuprSetr is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with SuprSetr.  If not, see <http://www.gnu.org/licenses/>.
*/

package net.jeremybrooks.suprsetr;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import net.jeremybrooks.jinx.dto.Photoset;
import net.jeremybrooks.suprsetr.utils.SSUtils;


/**
 * Extends the Photoset class to add metadata needed by SuprSetr.
 *
 * <p>The data added in this class contains everything SuprSetr needs to create,
 * refresh, and display a summary of a photoset. The data in here is saved to
 * the database, and these classes can be created from that data.</p>
 *
 * @author jeremyb
 */
public class SSPhotoset extends Photoset {

    private String tagMatchMode;
    private List<String> tags;
    private Date minUploadDate;
    private Date maxUploadDate;
    private Date minTakenDate;
    private Date maxTakenDate;
    private boolean matchUploadDates;
    private boolean matchTakenDates;
    private Date lastRefreshDate;
    private long syncTimestamp;
    private boolean managed;
    private ImageIcon primaryPhotoIcon;
    private int sortOrder;
    private boolean sendTweet;
    private String tweetTemplate;
    private boolean lockPrimaryPhoto;
    private transient boolean errorFlag = false;
    private transient boolean tweetWhenCreated = false;
    private transient int privacy = 0;
    private transient int safeSearch = 0;
    private transient int contentType = 6;
    private transient int mediaType = 0;
    private transient int geotagged = 0;
    private transient boolean inCommons = false;
    private transient boolean inGallery = false;
    private transient boolean inGetty = false;
    private transient boolean limitSize = false;
    private transient int sizeLimit = 0;
    private transient boolean onThisDay = false;
    private transient int onThisDayMonth = 1;
    private transient int onThisDayDay = 1;
    private transient int onThisDayYearStart = 1995;
    private transient int onThisDayYearEnd = SSUtils.getCurrentYear();


    public boolean isMetadataEqual(Photoset p) {
	if ((this.getTitle() == null) ? (p.getTitle() != null) : !this.getTitle().equals(p.getTitle())) {
	    return false;
	}
	if ((this.getDescription() == null) ? (p.getDescription() != null) : !this.getDescription().equals(p.getDescription())) {
	    return false;
	}
	if (this.getPhotos() != p.getPhotos()) {
	    return false;
	}
	return true;
    }

    public boolean isPhotosetEqual(Photoset p) {
	if ((this.getDescription() == null) ? (p.getDescription() != null) : !this.getDescription().equals(p.getDescription())) {
	    return false;
	}
	if ((this.getFarm() == null) ? (p.getFarm() != null) : !this.getFarm().equals(p.getFarm())) {
	    return false;
	}
	if ((this.getId() == null) ? (p.getId() != null) : !this.getId().equals(p.getId())) {
	    return false;
	}
	if (this.getPhotos() != p.getPhotos()) {
	    return false;
	}
	if ((this.getPrimary() == null) ? (p.getPrimary() != null) : !this.getPrimary().equals(p.getPrimary())) {
	    return false;
	}
	if ((this.getSecret() == null) ? (p.getSecret() != null) : !this.getSecret().equals(p.getSecret())) {
	    return false;
	}
	if ((this.getServer() == null) ? (p.getServer() != null) : !this.getServer().equals(p.getServer())) {
	    return false;
	}
	if ((this.getTitle() == null) ? (p.getTitle() != null) : !this.getTitle().equals(p.getTitle())) {
	    return false;
	}
	if ((this.getUrl() == null) ? (p.getUrl() != null) : !this.getUrl().equals(p.getUrl())) {
	    return false;
	}
	return true;
    }

    public void setPhotosetData(Photoset p) {
	super.setDescription(p.getDescription());
	super.setFarm(p.getFarm());
	super.setId(p.getId());
	super.setPhotos(p.getPhotos());
	super.setPrimary(p.getPrimary());
	super.setSecret(p.getSecret());
	super.setServer(p.getServer());
	super.setTitle(p.getTitle());
	super.setUrl(p.getUrl());
	
    }

    /**
     * @return the tags
     */
    public List<String> getTags() {
	return tags;
    }

    public String[] getTagsAsArray() {
	return tags.toArray(new String[0]);
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(List<String> tags) {
	this.tags = tags;
    }


    /**
     * @return the minUploadDate
     */
    public Date getMinUploadDate() {
	return minUploadDate;
    }


    /**
     * @param minUploadDate the minUploadDate to set
     */
    public void setMinUploadDate(Date minUploadDate) {
	this.minUploadDate = minUploadDate;
    }


    /**
     * @return the maxUploadDate
     */
    public Date getMaxUploadDate() {
	return maxUploadDate;
    }


    /**
     * @param maxUploadDate the maxUploadDate to set
     */
    public void setMaxUploadDate(Date maxUploadDate) {
	this.maxUploadDate = maxUploadDate;
    }


    /**
     * @return the minTakenDate
     */
    public Date getMinTakenDate() {
	return minTakenDate;
    }


    /**
     * @param minTakenDate the minTakenDate to set
     */
    public void setMinTakenDate(Date minTakenDate) {
	this.minTakenDate = minTakenDate;
    }


    /**
     * @return the maxTakenDate
     */
    public Date getMaxTakenDate() {
	return maxTakenDate;
    }


    /**
     * @param maxTakenDate the maxTakenDate to set
     */
    public void setMaxTakenDate(Date maxTakenDate) {
	this.maxTakenDate = maxTakenDate;
    }


    /**
     * @return the matchUploadDates
     */
    public boolean isMatchUploadDates() {
	return matchUploadDates;
    }


    /**
     * @param matchUploadDates the matchUploadDates to set
     */
    public void setMatchUploadDates(boolean matchUploadDates) {
	this.matchUploadDates = matchUploadDates;
    }


    /**
     * @return the matchTakenDates
     */
    public boolean isMatchTakenDates() {
	return matchTakenDates;
    }


    /**
     * @param matchTakenDates the matchTakenDates to set
     */
    public void setMatchTakenDates(boolean matchTakenDates) {
	this.matchTakenDates = matchTakenDates;
    }


    /**
     * @return the lastRefreshDate
     */
    public Date getLastRefreshDate() {
	return lastRefreshDate;
    }


    /**
     * @param lastRefreshDate the lastRefreshDate to set
     */
    public void setLastRefreshDate(Date lastRefreshDate) {
	this.lastRefreshDate = lastRefreshDate;
    }


    /**
     * @return the syncTimestamp
     */
    public long getSyncTimestamp() {
	return syncTimestamp;
    }


    /**
     * @param syncTimestamp the syncTimestamp to set
     */
    public void setSyncTimestamp(long syncTimestamp) {
	this.syncTimestamp = syncTimestamp;
    }


    /**
     * @return the managed
     */
    public boolean isManaged() {
	return managed;
    }


    /**
     * @param managed the managed to set
     */
    public void setManaged(boolean managed) {
	this.managed = managed;
    }


    /**
     * @return the primaryPhotoIcon
     */
    public ImageIcon getPrimaryPhotoIcon() {
	return primaryPhotoIcon;
    }


    /**
     * @param primaryPhotoIcon the primaryPhotoIcon to set
     */
    public void setPrimaryPhotoIcon(ImageIcon primaryPhotoIcon) {
	this.primaryPhotoIcon = primaryPhotoIcon;
    }


    /**
     * @return the tagMatchMode
     */
    public String getTagMatchMode() {
	return tagMatchMode;
    }


    /**
     * @param tagMatchMode the tagMatchMode to set
     */
    public void setTagMatchMode(String tagMatchMode) {
	this.tagMatchMode = tagMatchMode;
    }


    public String getTagsAsString() {
	StringBuilder sb = new StringBuilder();

	for (String s : this.tags) {
	    sb.append(s).append(", ");
	}
	
	if (sb.length() >= 2) {
	    sb.delete(sb.length() - 2, sb.length());
	}
	
	return sb.toString();
    }

    public void setTags(String tags) {
	this.tags = new ArrayList<String>();
	if (tags != null) {
	    StringTokenizer tok = new StringTokenizer(tags, ",");
	    while (tok.hasMoreTokens()) {
		this.tags.add(tok.nextToken().trim());
	    }
	}
    }



    /**
     * Returns a human-readable representation of the contents of this class.
     *
     * @return data in a string format.
     */
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("SSPhotoset [");

	sb.append("ID:").append(getId());
	sb.append(" | TITLE:").append(getTitle());
	sb.append(" | DESCRIPTION:").append(getDescription());
	sb.append(" | FARM:").append(getFarm());
	sb.append(" | SERVER:").append(getServer());
	sb.append(" | SECRET:").append(getSecret());
	sb.append(" | PHOTO COUNT:").append(getPhotos());
	sb.append(" | URL:").append(getUrl());
	sb.append(" | TAGS:").append(getTagsAsString());
	sb.append(" | TAG MATCH MODE:").append(tagMatchMode);
	sb.append(" | PRIMARY PHOTO ID:").append(getPrimary());
	sb.append(" | PRIMARY PHOTO ICON:").append(primaryPhotoIcon);
	sb.append(" | MATCH TAKEN DATES:").append(matchTakenDates);
	sb.append(" | MIN TAKEN DATE:").append(minTakenDate);
	sb.append(" | MAX TAKEN DATE:").append(maxTakenDate);
	sb.append(" | MATCH UPLOAD DATES:").append(matchUploadDates);
	sb.append(" | MIN UPLOAD DATE:").append(minUploadDate);
	sb.append(" | MAX UPLOAD DATE:").append(maxUploadDate);
	sb.append(" | LAST REFRESH DATE:").append(lastRefreshDate);
	sb.append(" | SYNC TIMESTAMP:").append(syncTimestamp);
	sb.append(" | MANAGED:").append(managed);
	sb.append(" | SORT ORDER:").append(sortOrder);
	sb.append('(').append(SSConstants.SORT_ORDER[sortOrder]).append(')');
	sb.append(" | SEND TWEET:").append(sendTweet);
	sb.append(" | TWEET TEMPLATE:'").append(tweetTemplate).append("'");
	sb.append(" | LOCK PRIMARY PHOTO:").append(lockPrimaryPhoto).append("'");
	sb.append(" | ERROR FLAG:'").append(errorFlag).append("'");
	sb.append(" | TWEET WHEN CREATED:'").append(tweetWhenCreated).append("'");
	sb.append(" | PRIVACY:'").append(privacy).append("'");
	sb.append(" | SAFE SEARCH:'").append(safeSearch).append("'");
	sb.append(" | CONTENT TYPE:'").append(contentType).append("'");
	sb.append(" | MEDIA TYPE:'").append(mediaType).append("'");
	sb.append(" | GEOTAGGED:'").append(geotagged).append("'");
	sb.append(" | IN COMMONS:'").append(inCommons).append("'");
	sb.append(" | IN GALLERY:'").append(inGallery).append("'");
	sb.append(" | IN GETTY:'").append(inGetty).append("'");
	sb.append(" | LIMIT SIZE:'").append(limitSize).append("'");
	sb.append(" | SIZE LIMIT:'").append(sizeLimit).append("'");
	sb.append(" | ON THIS DAY: '").append(onThisDay).append("'");
	sb.append(" | ON THIS DAY MONTH: '").append(onThisDayMonth).append("'");
	sb.append(" | ON THIS DAY DAY: '").append(onThisDayDay).append("'");
	sb.append(" | ON THIS DAY YEAR START: '").append(onThisDayYearStart).append("'");
	sb.append(" | ON THIS DAY YEAR END: '").append(onThisDayYearEnd).append("'");

	sb.append("] ");
	
	return sb.toString();
    }


    /**
     * @return the sortBy
     */
    public int getSortOrder() {
	return sortOrder;
    }


    /**
     * @param sortOrder the sortOrder to set
     */
    public void setSortOrder(int sortOrder) {
	this.sortOrder = sortOrder;
    }


    /**
     * @return the sendTweet
     */
    public boolean isSendTweet() {
	return sendTweet;
    }


    /**
     * @param sendTweet the sendTweet to set
     */
    public void setSendTweet(boolean sendTweet) {
	this.sendTweet = sendTweet;
    }


    /**
     * @return the tweetTemplate
     */
    public String getTweetTemplate() {
	return tweetTemplate;
    }


    /**
     * @param tweetTemplate the tweetTemplate to set
     */
    public void setTweetTemplate(String tweetTemplate) {
	this.tweetTemplate = tweetTemplate;
    }


    /**
     * @return the lockPrimaryPhoto
     */
    public boolean isLockPrimaryPhoto() {
	return lockPrimaryPhoto;
    }


    /**
     * @param lockPrimaryPhoto the lockPrimaryPhoto to set
     */
    public void setLockPrimaryPhoto(boolean lockPrimaryPhoto) {
	this.lockPrimaryPhoto = lockPrimaryPhoto;
    }

    
    /**
     * 
     * @return the errorFlag
     */
    public boolean isErrorFlag() {
	return errorFlag;
    }
    
    /**
     * @param errorFlag the errorFlag to set
     */
    public void setErrorFlag(boolean errorFlag) {
	this.errorFlag = errorFlag;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final SSPhotoset other = (SSPhotoset) obj;
	if ((super.getId() == null) ? (other.getId() != null) : !super.getId().equals(other.getId())) {
	    return false;
	}
	return true;
    }


    @Override
    public int hashCode() {
	int hash = 3;
	hash = 79 * hash + (super.getId() != null ? super.getId().hashCode() : 0);
	return hash;
    }


    /**
     * @return the tweetWhenCreated
     */
    public boolean isTweetWhenCreated() {
	return tweetWhenCreated;
    }


    /**
     * @param tweetWhenCreated the tweetWhenCreated to set
     */
    public void setTweetWhenCreated(boolean tweetWhenCreated) {
	this.tweetWhenCreated = tweetWhenCreated;
    }


    /**
     * @return the privacy
     */
    public int getPrivacy() {
	return privacy;
    }


    /**
     * @param privacy the privacy to set
     */
    public void setPrivacy(int privacy) {
	this.privacy = privacy;
    }


    /**
     * @return the safeSearch
     */
    public int getSafeSearch() {
	return safeSearch;
    }


    /**
     * @param safeSearch the safeSearch to set
     */
    public void setSafeSearch(int safeSearch) {
	this.safeSearch = safeSearch;
    }


    /**
     * @return the contentType
     */
    public int getContentType() {
	return contentType;
    }


    /**
     * @param contentType the contentType to set
     */
    public void setContentType(int contentType) {
	this.contentType = contentType;
    }


    /**
     * @return the mediaType
     */
    public int getMediaType() {
	return mediaType;
    }


    /**
     * @param mediaType the mediaType to set
     */
    public void setMediaType(int mediaType) {
	this.mediaType = mediaType;
    }


    /**
     * @return the geotagged
     */
    public int getGeotagged() {
	return geotagged;
    }


    /**
     * @param geotagged the geotagged to set
     */
    public void setGeotagged(int geotagged) {
	this.geotagged = geotagged;
    }


    /**
     * @return the inCommons
     */
    public boolean isInCommons() {
	return inCommons;
    }


    /**
     * @param inCommons the inCommons to set
     */
    public void setInCommons(boolean inCommons) {
	this.inCommons = inCommons;
    }


    /**
     * @return the inGallery
     */
    public boolean isInGallery() {
	return inGallery;
    }


    /**
     * @param inGallery the inGallery to set
     */
    public void setInGallery(boolean inGallery) {
	this.inGallery = inGallery;
    }


    /**
     * @return the inGetty
     */
    public boolean isInGetty() {
	return inGetty;
    }


    /**
     * @param inGetty the inGetty to set
     */
    public void setInGetty(boolean inGetty) {
	this.inGetty = inGetty;
    }


    /**
     * @return the limitSize
     */
    public boolean isLimitSize() {
	return limitSize;
    }


    /**
     * @param limitSize the limitSize to set
     */
    public void setLimitSize(boolean limitSize) {
	this.limitSize = limitSize;
    }


    /**
     * @return the sizeLimit
     */
    public int getSizeLimit() {
	return sizeLimit;
    }


    /**
     * @param sizeLimit the sizeLimit to set
     */
    public void setSizeLimit(int sizeLimit) {
	this.sizeLimit = sizeLimit;
    }


    /**
     * @return the onThisDay
     */
    public boolean isOnThisDay() {
	return onThisDay;
    }


    /**
     * @param onThisDay the onThisDay to set
     */
    public void setOnThisDay(boolean onThisDay) {
	this.onThisDay = onThisDay;
    }


    /**
     * @return the onThisDayMonth
     */
    public int getOnThisDayMonth() {
	return onThisDayMonth;
    }


    /**
     * @param onThisDayMonth the onThisDayMonth to set
     */
    public void setOnThisDayMonth(int onThisDayMonth) {
	this.onThisDayMonth = onThisDayMonth;
    }


    /**
     * @return the onThisDayDay
     */
    public int getOnThisDayDay() {
	return onThisDayDay;
    }


    /**
     * @param onThisDayDay the onThisDayDay to set
     */
    public void setOnThisDayDay(int onThisDayDay) {
	this.onThisDayDay = onThisDayDay;
    }


    /**
     * @return the onThisDayStartYear
     */
    public int getOnThisDayYearStart() {
	return onThisDayYearStart;
    }


    /**
     * @param onThisDayStartYear the onThisDayStartYear to set
     */
    public void setOnThisDayYearStart(int onThisDayYearStart) {
	this.onThisDayYearStart = onThisDayYearStart;
    }


    /**
     * @return the onThisDayEndYear
     */
    public int getOnThisDayYearEnd() {
	return onThisDayYearEnd;
    }


    /**
     * @param onThisDayEndYear the onThisDayEndYear to set
     */
    public void setOnThisDayYearEnd(int onThisDayYearEnd) {
	this.onThisDayYearEnd = onThisDayYearEnd;
    }




}
