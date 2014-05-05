	
	import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
	
	public class CandidateCode {
	
		private static class Cell {
			public int x;
			public int y;
	
			public Cell(int x, int y) {
				this.x = x;
				this.y = y;
			}
			@Override
			public String toString() {
				return this.x + "#"+this.y;
			}
	
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + x;
				result = prime * result + y;
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
				Cell other = (Cell) obj;
				if (x != other.x)
					return false;
				if (y != other.y)
					return false;
				return true;
			}
	
		}
	
		private static Map<Cell, Integer> distanceMap = new HashMap<CandidateCode.Cell, Integer>();
	
		public static String[] getPosition(String battleFieldSize,
				String startingPoint, String target, String[] bulletProofCells) {
			List<Cell> bulletProofCellsList = new ArrayList<Cell>();
			for (String pair : bulletProofCells) {
				Cell bulletProofCell;
				if(!pair.contains(",")){
					 bulletProofCell = new Cell(
							Integer.parseInt(pair), Integer.parseInt(pair));
				}else{
				
				  bulletProofCell = new Cell(
						Integer.parseInt(pair.split(",")[0]), Integer.parseInt(pair
								.split(",")[1]));
				}
				bulletProofCellsList.add(bulletProofCell);
			}
	
			Cell size = new Cell(Integer.parseInt(battleFieldSize.split(",")[0]),
					Integer.parseInt(battleFieldSize.split(",")[1]));
	
			Cell start = new Cell(Integer.parseInt(startingPoint.split(",")[0]),
					Integer.parseInt(startingPoint.split(",")[1]));
	
			Cell targetCell = new Cell(Integer.parseInt(target.split(",")[0]),
					Integer.parseInt(target.split(",")[1]));
	
			// right
			int x = targetCell.x + 1;
			int y = targetCell.y;
			while (x < size.x) {
				int distance = Math.abs(x - start.x)
						+ Math.abs(y - start.y);
				distanceMap.put(new Cell(x, y), distance);
				x++;
				if ((bulletProofCellsList.contains(new Cell(x, y))))
					break;
			}
	
			// left
			x = targetCell.x - 1;
			y = targetCell.y;
			while (x >= 0) {
				int distance = Math.abs(x - start.x)
						+ Math.abs(y - start.y);
				distanceMap.put(new Cell(x, y), distance);
				x--;
				if ((bulletProofCellsList.contains(new Cell(x, y))))
					break;
			}
	
			// up
			x = targetCell.x;
			y = targetCell.y + 1;
			while (y < size.y) {
				int distance = Math.abs(x - start.x)
						+ Math.abs(y - start.y);
				distanceMap.put(new Cell(x, y), distance);
				y++;
				if ((bulletProofCellsList.contains(new Cell(x, y))))
					break;
			}
	
			// down
			x = targetCell.x;
			y = targetCell.y - 1;
			while (y >= 0) {
				int distance = Math.abs(x - start.x)
						+ Math.abs(y - start.y);
				distanceMap.put(new Cell(x, y), distance);
				y--;
				if ((bulletProofCellsList.contains(new Cell(x, y))))
					break;
			}
	
			// top right
			x = targetCell.x+1;
			y = targetCell.y + 1;
			while (x< size.x && y < size.y) {
				int distance = Math.abs(x - start.x)
						+ Math.abs(y - start.y);
				distanceMap.put(new Cell(x, y), distance);
				y++;
				x++;
				if ((bulletProofCellsList.contains(new Cell(x, y))))
					break;
			}
	
			
			// top left
					x = targetCell.x-1;
					y = targetCell.y + 1;
					while (x>=0 && y < size.y) {
						int distance = Math.abs(x - start.x)
								+ Math.abs(y - start.y);
						distanceMap.put(new Cell(x, y), distance);
						y++;
						x--;
						if ((bulletProofCellsList.contains(new Cell(x, y))))
							break;
					}
					
					// bottom right
					x = targetCell.x+1;
					y = targetCell.y - 1;
					while (x< size.x && y <=0) {
						int distance = Math.abs(x - start.x)
								+ Math.abs(y - start.y);
						distanceMap.put(new Cell(x, y), distance);
						y--;
						x++;
						if ((bulletProofCellsList.contains(new Cell(x, y))))
							break;
					}
	
					// bottom left
					x = targetCell.x-1;
					y = targetCell.y - 1;
					while (x>=0 && y >=0) {
						int distance = Math.abs(x - start.x)
								+ Math.abs(y - start.y);
						distanceMap.put(new Cell(x, y), distance);
						y--;
						x--;
						if ((bulletProofCellsList.contains(new Cell(x, y))))
							break;
					}
	
					
					Integer minDistance = Collections.min(distanceMap.values());
					List<String> resultList = new ArrayList<String>();
					for (Cell cell : distanceMap.keySet()) {
						if(distanceMap.get(cell) == minDistance){
							resultList.add(cell.x+"#"+cell.y);
						}
							
					}
	
			return  (String[]) resultList.toArray(new String[0]);
		}
		
		public static void main(String[] args) {
			String[] positions = CandidateCode.getPosition("25,25", "1,5", "10,14", new String[]{"0"});
			for (String string : positions) {
				System.out.println(string);
			}
		}
	}
