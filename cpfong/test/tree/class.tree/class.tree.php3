<?
	// class.tree.php3 
        // (c) 1999, 2000 Patrick Hess <hess@dland.de>

	class Tree {
		// configuration
		var $tree_ftv2blank 		= "ftv2blank.gif";
		var $tree_ftv2doc 		= "ftv2doc.gif";
		var $tree_ftv2folderclosed 	= "ftv2folderclosed.gif";
		var $tree_ftv2folderopen 	= "ftv2folderopen.gif";
		var $tree_ftv2lastnode 		= "ftv2lastnode.gif";
		var $tree_ftv2link 		= "ftv2link.gif";
		var $tree_ftv2mlastnode 	= "ftv2mlastnode.gif";
		var $tree_ftv2mnode 		= "ftv2mnode.gif";
		var $tree_ftv2node 		= "ftv2node.gif";
		var $tree_ftv2plastnode 	= "ftv2plastnode.gif";
		var $tree_ftv2pnode 		= "ftv2pnode.gif";
		var $tree_ftv2vertline 		= "ftv2vertline.gif";
		var $tree_basefrm 		= "_top";

		// internal data
		var $tree_path;
		var $tree_count = 1;

		function Tree ($t_path = "class.tree") 
		{
			$this->tree_path = $t_path;
		}

		function open_tree ($t_text, $t_url)
		{
?>
<script>
classPath = <? echo "\"$this->tree_path\";\n"; ?>
ftv2blank = <? echo "\"$this->tree_ftv2blank\""; ?>;
ftv2doc = <? echo "\"$this->tree_ftv2doc\""; ?>;
ftv2folderclosed = <? echo "\"$this->tree_ftv2folderclosed\""; ?>;
ftv2folderopen = <? echo "\"$this->tree_ftv2folderopen\""; ?>;
ftv2lastnode = <? echo "\"$this->tree_ftv2lastnode\""; ?>;
ftv2link = <? echo "\"$this->tree_ftv2link\""; ?>;
ftv2mlastnode = <? echo "\"$this->tree_ftv2mlastnode\""; ?>;
ftv2mnode = <? echo "\"$this->tree_ftv2mnode\""; ?>;
ftv2node = <? echo "\"$this->tree_ftv2node\""; ?>;
ftv2plastnode = <? echo "\"$this->tree_ftv2plastnode\""; ?>;
ftv2pnode = <? echo "\"$this->tree_ftv2pnode\""; ?>;
ftv2vertline = <? echo "\"$this->tree_ftv2vertline\""; ?>;
basefrm = <? echo "\"$this->tree_basefrm\""; ?>;
</script><script src=<?	echo "\"$this->tree_path/ftiens4.js\""; 
?> type="text/javascript">
</script><script>
<?			echo "\n";

			$jsvn = "foldersTree";
			echo "$jsvn = gFld(\"$t_text\", \"$t_url\")\n";
			return ($jsvn);
		}

		function add_folder ($t_parent, $t_text, $t_url) 
		{  
			$jsvn = "aux".$this->tree_count;
			$this->tree_count++;
			echo "$jsvn = insFld($t_parent, gFld (\"$t_text\", ";
			echo "\"$t_url\"))\n";
			return ($jsvn);
		}		

		function add_document ($t_parent, $t_text, $t_url) 
		{ 
			echo "insDoc($t_parent, gLnk ($t_parent, \"$t_text\", ";
			echo "\"$t_url\"))\n";
		}	

		function close_tree ( )
		{
			echo "\ninitializeDocument()\n</script>";
		}
	}
?>

