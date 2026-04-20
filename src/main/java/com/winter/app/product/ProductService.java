package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.file.FileManager;
import com.winter.app.pager.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.product.image}")
	private String name;
	
	public List<ProductDTO> list(Pager pager) throws Exception {
		pager.makePageNum(productMapper.getCount(pager));
		pager.makeStartNum();
		
		return productMapper.list(pager);		
	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		return productMapper.detail(productDTO);

	}
	
	public int create(ProductDTO productDTO, MultipartFile[] attach) throws Exception {
		int result = productMapper.create(productDTO);
		
		if(attach==null) {
			return result;
		}
		
		for(MultipartFile f:attach) {
			if(f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(name, f);
			
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setOriName(f.getOriginalFilename());
			productFileDTO.setProductNum(productDTO.getProductNum());
			productFileDTO.setFileName(fileName);
			
			result = productMapper.createFile(productFileDTO);
			
		}
		
		return result;
	}

}
