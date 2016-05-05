/**
 * 	    Control Work 			17.02.2015
 *
 * 	    POJO (Java Been) News
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru 
 */

package pojos;

import java.io.Serializable;

public class News implements Serializable {
    private static final long serialVersionUID = 22L;

	private int id; 			// ID News
	private String category;	// Category of News (Politic, Economic ...)
	private String title; 		// Title of news (Headline)
	private String annotation; 	// Annatation to News
	private String author; 		// Author of News
	private String agency; 		// Information Agency like Reiters, TASS, RIA
	private String drelease;	// Date of release News
	private String document; 	// Text of News
	
	public News() {}  //Constructor with out param

    /**
     * Constructor with param
     */
	public News(int id, String category, String title, String annotation, String author, String agency, String drelease, String document) {
		setId(id);		        // ID News
		setCategory(category);	// Category of News (Politic, Economic ...)
		setTitle(title);		// Title of news (Headline)
		setAnnotation(annotation);// Annatation to News
		setAuthor(author);		// Author of News
		setAgency(agency);		// Information Agency like Reiters, TASS, RIA
		setDrelease(drelease);	// Date of release News
		setDocument(document);	// Text of News
	}
	
	/**
	 * GET  ID News
	 */
	public int getId() {
		return id;
	}
	/**
	 * SET  ID News
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * GET  Category of News (Politic, Economic ...)
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * SET  Category of News (Politic, Economic ...)
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * GET  Title of news (Headline)
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * SET  Title of news (Headline)
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * GET  Annatation to News
	 */
	public String getAnnotation() {
		return annotation;
	}
	/**
	 * SET  Annatation to News
	 */
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	/**
	 * GET  Author of News
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * SET  Author of News
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * GET  Information Agency like Reiters, TASS, RIA
	 */
	public String getAgency() {
		return agency;
	}
	/**
	 * SET  Information Agency like Reiters, TASS, RIA
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}
	/**
	 * GET  Date of release News
	 */
	public String getDrelease() {
		return drelease;
	}
	/**
	 * SET  Date of release News
	 */
	public void setDrelease(String drelease) {
		this.drelease = drelease;
	}
	/**
	 * GET  Text of News
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * SET  Text of News
	 */
	public void setDocument(String document) {
		this.document = document;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof News))
            return false;
        News other = (News) obj;
        if (agency == null) {
            if (other.agency != null)
                return false;
        } else if (!agency.equals(other.agency))
            return false;
        if (annotation == null) {
            if (other.annotation != null)
                return false;
        } else if (!annotation.equals(other.annotation))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (document == null) {
            if (other.document != null)
                return false;
        } else if (!document.equals(other.document))
            return false;
        if (drelease == null) {
            if (other.drelease != null)
                return false;
        } else if (!drelease.equals(other.drelease))
            return false;
        if (id != other.id)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((agency == null) ? 0 : agency.hashCode());
        result = prime * result
                + ((annotation == null) ? 0 : annotation.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result
                + ((category == null) ? 0 : category.hashCode());
        result = prime * result
                + ((document == null) ? 0 : document.hashCode());
        result = prime * result
                + ((drelease == null) ? 0 : drelease.hashCode());
        result = prime * result + id;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "News [id=" + id + ", category=" + category + ", title=" + title
                + ", annotation=" + annotation + ", author=" + author
                + ", agency=" + agency + ", drelease=" + drelease
                + ", document=" + document + "]";
    }
}