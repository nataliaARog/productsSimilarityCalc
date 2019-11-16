<%@ tag language="java" pageEncoding="UTF-8"%>

<h1>Products List</h1>

<input type="text" maxlength="4" class="input-product"></input>
<input type="submit" value="search and calculate" class="button-product" />

<table id="productsTable">
	<thead>
    	<tr>
        	<th>Id</th>
			<th>Name</th>
			<th>detail</th>
			<th class="empty-th"></th>
			<th class="empty-th"></th>
		</tr>
	</thead>
	<tbody>		
	</tbody>
</table>

<div id="productDetailModal" class="modal">
	<div class="modal-content">
		<h2>Product Detail</h2>
		<p>
			<span class="subtitle-modal">Product characteristics</span>
			<span id="tags" class="text-modal"></span>
		</p>		
		<p id="contentTwo">
			<span class="subtitle-modal">Product characteristics level</span>
			<span id="tagsVector" class="text-modal"></span>
		</p>
		
	</div>
</div>