package karthikeyancc.dbstest.dto;
import java.io.Serializable;
import java.util.List;
public class FileDto implements Serializable{
	private String name;
	private Long size;
	private Boolean read;
	private Boolean write;
	private Boolean execute;
	private List<FileDto> child;
	private static final long serialVersionUID = 42L;
	public FileDto(String name,  List<FileDto> child,Long size,Boolean read,Boolean write, Boolean execute) {
		super();
		this.name = name;
		this.size = size;
		this.child = child;
		this.read=read;
		this.write=write;
		this.execute=execute;
	}
	public String getName() {
		return name;
	}
	public List<FileDto> getChild() {
		return child;
	}
	
	public Long getSize() {
		return size;
	}

	public Boolean getRead() {
		return read;
	}

	public Boolean getWrite() {
		return write;
	}
	
	public Boolean getExecute() {
		return execute;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((child == null) ? 0 : child.hashCode());
		result = prime * result + ((execute == null) ? 0 : execute.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((read == null) ? 0 : read.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((write == null) ? 0 : write.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileDto other = (FileDto) obj;
		if (child == null) {
			if (other.child != null)
				return false;
		} else if (!child.equals(other.child))
			return false;
		if (execute == null) {
			if (other.execute != null)
				return false;
		} else if (!execute.equals(other.execute))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (read == null) {
			if (other.read != null)
				return false;
		} else if (!read.equals(other.read))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (write == null) {
			if (other.write != null)
				return false;
		} else if (!write.equals(other.write))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FileDto [name=" + name + ", size=" + size + ", read=" + read + ", write=" + write + ", execute="
				+ execute + ", child=" + child + "]";
	}

}