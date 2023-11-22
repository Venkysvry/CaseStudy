package com.cropfield.project.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cropId_sequence")
	public class DatabaseSequence {

	    @Id
	    private String id;

	    private long seq;

		public DatabaseSequence() {
			
			
		}

		public DatabaseSequence(String id, long seq) {
			super();
			this.id = id;
			this.seq = seq;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public long getSeq() {
			return seq;
		}

		public void setSeq(long seq) {
			this.seq = seq;
		}

		@Override
		public String toString() {
			return "DatabaseSequence [id=" + id + ", seq=" + seq + "]";
		}

	  
	
}
