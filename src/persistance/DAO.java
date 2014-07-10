package persistance;


	public interface DAO <T>{

	    public T findById(Long id);
	      
	    public T insert(T entity);
	    
	    public boolean deletById(T entity);
	    
	    public boolean update(T entity);

	}
